package com.ruoyi.books.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.books.domain.BookInfo;
import com.ruoyi.books.service.IBookInfoService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 图书信息Controller
 *
 * @author ruoyi
 * @date 2024-02-20
 */
@RestController
@RequestMapping("/book/info")
public class BookInfoController extends BaseController {
    @Autowired
    private IBookInfoService bookInfoService;

/**
 * 查询图书信息列表
 */
@PreAuthorize("@ss.hasPermi('book:info:list')")
@GetMapping("/list")
    public TableDataInfo list(BookInfo bookInfo) {
        startPage();
        List<BookInfo> list = bookInfoService.selectBookInfoList(bookInfo);
        return getDataTable(list);
    }

    /**
     * 导出图书信息列表
     */
    @PreAuthorize("@ss.hasPermi('book:info:export')")
    @Log(title = "图书信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BookInfo bookInfo) {
        List<BookInfo> list = bookInfoService.selectBookInfoList(bookInfo);
        ExcelUtil<BookInfo> util = new ExcelUtil<BookInfo>(BookInfo. class);
        util.exportExcel(response, list, "图书信息数据");
    }

    /**
     * 获取图书信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('book:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(bookInfoService.selectBookInfoById(id));
    }

    /**
     * 新增图书信息
     */
    @PreAuthorize("@ss.hasPermi('book:info:add')")
    @Log(title = "图书信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BookInfo bookInfo) {
        return toAjax(bookInfoService.insertBookInfo(bookInfo));
    }

    /**
     * 修改图书信息
     */
    @PreAuthorize("@ss.hasPermi('book:info:edit')")
    @Log(title = "图书信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BookInfo bookInfo) {
        return toAjax(bookInfoService.updateBookInfo(bookInfo));
    }

    /**
     * 删除图书信息
     */
    @PreAuthorize("@ss.hasPermi('book:info:remove')")
    @Log(title = "图书信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(bookInfoService.deleteBookInfoByIds(ids));
    }
}
