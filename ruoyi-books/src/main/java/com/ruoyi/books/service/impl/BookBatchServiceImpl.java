package com.ruoyi.books.service.impl;

import java.util.List;

import com.ruoyi.books.domain.BookBatch;
import com.ruoyi.books.mapper.BookBatchMapper;
import com.ruoyi.books.service.IBookBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 进书批次Service业务层处理
 *
 * @author ruoyi
 * @date 2024-02-20
 */
@Service
public class BookBatchServiceImpl implements IBookBatchService {
    @Autowired
    private BookBatchMapper bookBatchMapper;

    /**
     * 查询进书批次
     *
     * @param id 进书批次主键
     * @return 进书批次
     */
    @Override
    public BookBatch selectBookBatchById(Long id) {
        return bookBatchMapper.selectBookBatchById(id);
    }

    /**
     * 查询进书批次列表
     *
     * @param bookBatch 进书批次
     * @return 进书批次
     */
    @Override
    public List<BookBatch> selectBookBatchList(BookBatch bookBatch) {
        return bookBatchMapper.selectBookBatchList(bookBatch);
    }

    /**
     * 新增进书批次
     *
     * @param bookBatch 进书批次
     * @return 结果
     */
    @Override
    public int insertBookBatch(BookBatch bookBatch) {
            return bookBatchMapper.insertBookBatch(bookBatch);
    }

    /**
     * 修改进书批次
     *
     * @param bookBatch 进书批次
     * @return 结果
     */
    @Override
    public int updateBookBatch(BookBatch bookBatch) {
        return bookBatchMapper.updateBookBatch(bookBatch);
    }

    /**
     * 批量删除进书批次
     *
     * @param ids 需要删除的进书批次主键
     * @return 结果
     */
    @Override
    public int deleteBookBatchByIds(Long[] ids) {
        return bookBatchMapper.deleteBookBatchByIds(ids);
    }

    /**
     * 删除进书批次信息
     *
     * @param id 进书批次主键
     * @return 结果
     */
    @Override
    public int deleteBookBatchById(Long id) {
        return bookBatchMapper.deleteBookBatchById(id);
    }
}
