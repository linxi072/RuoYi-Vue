package com.ruoyi.books.mapper;

import com.ruoyi.books.domain.BookInfo;

import java.util.List;

/**
 * 图书信息Mapper接口
 *
 * @author ruoyi
 * @date 2024-02-20
 */
public interface BookInfoMapper {
    /**
     * 查询图书信息
     *
     * @param id 图书信息主键
     * @return 图书信息
     */
    public BookInfo selectBookInfoById(Long id);

    /**
     * 查询图书信息列表
     *
     * @param bookInfo 图书信息
     * @return 图书信息集合
     */
    public List<BookInfo> selectBookInfoList(BookInfo bookInfo);

    /**
     * 新增图书信息
     *
     * @param bookInfo 图书信息
     * @return 结果
     */
    public int insertBookInfo(BookInfo bookInfo);

    /**
     * 修改图书信息
     *
     * @param bookInfo 图书信息
     * @return 结果
     */
    public int updateBookInfo(BookInfo bookInfo);

    /**
     * 删除图书信息
     *
     * @param id 图书信息主键
     * @return 结果
     */
    public int deleteBookInfoById(Long id);

    /**
     * 批量删除图书信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBookInfoByIds(Long[] ids);
}
