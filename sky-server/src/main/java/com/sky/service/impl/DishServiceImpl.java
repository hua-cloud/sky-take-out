package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.MessageConstant;
import com.sky.constant.StatusConstant;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.exception.DeletionNotAllowedException;
import com.sky.mapper.DishFlavorMapper;
import com.sky.mapper.DishMapper;
import com.sky.mapper.SetmealDishMapper;
import com.sky.result.PageResult;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishMapper dishMapper;

    @Autowired
    private DishFlavorMapper dishFlavorMapper;

    @Autowired
    private SetmealDishMapper setmealDishMapper;

    @Transactional
    public void saveWithFlavor(DishDTO dishDTO) {
        Dish dish = new Dish();
        // 使用Spring Bean映射工具拷贝对象属性
        BeanUtils.copyProperties(dishDTO, dish);

        // 向菜单表中插入一条数据
        dishMapper.insert(dish);

        // 获取insert语句生成的主键值
        Long dishId = dish.getId();

        List<DishFlavor> flavors = dishDTO.getFlavors();
        if (flavors != null && flavors.size() > 0) {
            // 遍历list集合中的元素，为每个对象中的dishId属性赋值
            flavors.forEach(dishFlavor -> { // lambda表达式
                dishFlavor.setDishId(dishId);
            });
            // 向口味表中插入n条数据
            dishFlavorMapper.batchInsert(flavors);
        }
    }

    @Override
    public PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO) {
        PageHelper.startPage(dishPageQueryDTO.getPage(), dishPageQueryDTO.getPageSize());
        Page<DishVO> page = dishMapper.pageQuery(dishPageQueryDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void deleteBatch(List<Long> ids) {
        // 1. 判断当前菜品是否可以被删除---是否存在起售中的菜品
        ids.forEach(id -> {
            Dish dish = dishMapper.getById(id);
            // 当前菜品处于起售中，不允许删除
            if (dish.getStatus() == StatusConstant.ENABLE) {
                throw new DeletionNotAllowedException(MessageConstant.DISH_ON_SALE);
            }
        });
        // 2. 判断当前菜品是否可以被删除---是否被套餐关联了
        List<Long> setmealIds = setmealDishMapper.getSetmealIdsByDishIds(ids);
        if (setmealIds != null && setmealIds.size() > 0) {
            // 菜品被套餐关联了，也不允许删除
            throw new DeletionNotAllowedException(MessageConstant.DISH_BE_RELATED_BY_SETMEAL);
        }
        // 3. 删除菜品数据
        ids.forEach(id -> {
            dishMapper.deleteById(id);
            // 4. 删除与菜品关联的口味数据
            dishFlavorMapper.deleteByDishId(id);
        });
    }

    @Override
    public DishVO getByIdWithFlavor(Long id) {
        // 1. 根据id查询菜品数据
        Dish dish = dishMapper.getById(id);

        // 2，根据菜品id查询对应的口味
        List<DishFlavor> dishFlavors = dishFlavorMapper.getByDishId(id);

        // 3. 将上面查询的数据封装到DishVo对象中
        DishVO dishVO = new DishVO();
        BeanUtils.copyProperties(dish, dishVO);
        dishVO.setFlavors(dishFlavors);

        return dishVO;
    }

    @Override
    public void updateWithFlavor(DishDTO dishDTO) {
        // 1. 修改菜品的基本信息
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO, dish);
        dishMapper.update(dish);

        // 2. 删除原有的口味数据
        dishFlavorMapper.deleteByDishId(dishDTO.getId());

        // 3. 重新插入新的口味数据
        List<DishFlavor> flavors = dishDTO.getFlavors();
        if (flavors != null && flavors.size() > 0) {
            // 遍历list集合中的元素，为每个对象中的dishId属性赋值
            flavors.forEach(dishFlavor -> { // lambda表达式
                dishFlavor.setDishId(dishDTO.getId());
            });
            // 向口味表中插入n条数据
            dishFlavorMapper.batchInsert(flavors);
        }
    }


}
