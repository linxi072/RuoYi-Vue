package com.ruoyi.books.service.impl;

import java.util.List;

import com.ruoyi.books.domain.BookOrder;
import com.ruoyi.books.mapper.BookOrderMapper;
import com.ruoyi.books.service.IBookOrderService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 进货单Service业务层处理
 *
 * @author ruoyi
 * @date 2024-02-20
 */
@Service
public class BookOrderServiceImpl implements IBookOrderService {
    @Autowired
    private BookOrderMapper bookOrderMapper;

    /**
     * 查询进货单
     *
     * @param id 进货单主键
     * @return 进货单
     */
    @Override
    public BookOrder selectBookOrderById(Long id) {
        return bookOrderMapper.selectBookOrderById(id);
    }

    /**
     * 查询进货单列表
     *
     * @param bookOrder 进货单
     * @return 进货单
     */
    @Override
    public List<BookOrder> selectBookOrderList(BookOrder bookOrder) {
        return bookOrderMapper.selectBookOrderList(bookOrder);
    }

    /**
     * 新增进货单
     *
     * @param bookOrder 进货单
     * @return 结果
     */
    @Override
    public int insertBookOrder(BookOrder bookOrder) {
                bookOrder.setCreateTime(DateUtils.getNowDate());
            return bookOrderMapper.insertBookOrder(bookOrder);
    }

    /**
     * 修改进货单
     *
     * @param bookOrder 进货单
     * @return 结果
     */
    @Override
    public int updateBookOrder(BookOrder bookOrder) {
                bookOrder.setUpdateTime(DateUtils.getNowDate());
        return bookOrderMapper.updateBookOrder(bookOrder);
    }

    /**
     * 批量删除进货单
     *
     * @param ids 需要删除的进货单主键
     * @return 结果
     */
    @Override
    public int deleteBookOrderByIds(Long[] ids) {
        return bookOrderMapper.deleteBookOrderByIds(ids);
    }

    /**
     * 删除进货单信息
     *
     * @param id 进货单主键
     * @return 结果
     */
    @Override
    public int deleteBookOrderById(Long id) {
        return bookOrderMapper.deleteBookOrderById(id);
    }
}
