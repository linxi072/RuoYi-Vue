package com.ruoyi.books.mapper;

import com.ruoyi.books.domain.BookBatch;

import java.util.List;


/**
 * 进书批次Mapper接口
 *
 * @author ruoyi
 * @date 2024-02-20
 */
public interface BookBatchMapper {
    /**
     * 查询进书批次
     *
     * @param id 进书批次主键
     * @return 进书批次
     */
    public BookBatch selectBookBatchById(Long id);

    /**
     * 查询进书批次列表
     *
     * @param bookBatch 进书批次
     * @return 进书批次集合
     */
    public List<BookBatch> selectBookBatchList(BookBatch bookBatch);

    /**
     * 新增进书批次
     *
     * @param bookBatch 进书批次
     * @return 结果
     */
    public int insertBookBatch(BookBatch bookBatch);

    /**
     * 修改进书批次
     *
     * @param bookBatch 进书批次
     * @return 结果
     */
    public int updateBookBatch(BookBatch bookBatch);

    /**
     * 删除进书批次
     *
     * @param id 进书批次主键
     * @return 结果
     */
    public int deleteBookBatchById(Long id);

    /**
     * 批量删除进书批次
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBookBatchByIds(Long[] ids);
}
