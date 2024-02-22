package com.ruoyi.books.service;

import com.ruoyi.books.domain.BookOrder;

import java.util.List;


/**
 * 进货单Service接口
 *
 * @author ruoyi
 * @date 2024-02-20
 */
public interface IBookOrderService {
    /**
     * 查询进货单
     *
     * @param id 进货单主键
     * @return 进货单
     */
    public BookOrder selectBookOrderById(Long id);

    /**
     * 查询进货单列表
     *
     * @param bookOrder 进货单
     * @return 进货单集合
     */
    public List<BookOrder> selectBookOrderList(BookOrder bookOrder);

    /**
     * 新增进货单
     *
     * @param bookOrder 进货单
     * @return 结果
     */
    public int insertBookOrder(BookOrder bookOrder);

    /**
     * 修改进货单
     *
     * @param bookOrder 进货单
     * @return 结果
     */
    public int updateBookOrder(BookOrder bookOrder);

    /**
     * 批量删除进货单
     *
     * @param ids 需要删除的进货单主键集合
     * @return 结果
     */
    public int deleteBookOrderByIds(Long[] ids);

    /**
     * 删除进货单信息
     *
     * @param id 进货单主键
     * @return 结果
     */
    public int deleteBookOrderById(Long id);
}
