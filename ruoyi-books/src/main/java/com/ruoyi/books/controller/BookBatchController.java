package com.ruoyi.books.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.books.domain.BookBatch;
import com.ruoyi.books.service.IBookBatchService;
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
 * 进书批次Controller
 *
 * @author ruoyi
 * @date 2024-02-20
 */
@RestController
@RequestMapping("/book/batch")
public class BookBatchController extends BaseController {
    @Autowired
    private IBookBatchService bookBatchService;

/**
 * 查询【请填写功能名称】列表
 */
@PreAuthorize("@ss.hasPermi('book:batch:list')")
@GetMapping("/list")
    public TableDataInfo list(BookBatch bookBatch) {
        startPage();
        List<BookBatch> list = bookBatchService.selectBookBatchList(bookBatch);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('book:batch:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BookBatch bookBatch) {
        List<BookBatch> list = bookBatchService.selectBookBatchList(bookBatch);
        ExcelUtil<BookBatch> util = new ExcelUtil<BookBatch>(BookBatch. class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('book:batch:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(bookBatchService.selectBookBatchById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('book:batch:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BookBatch bookBatch) {
        return toAjax(bookBatchService.insertBookBatch(bookBatch));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('book:batch:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BookBatch bookBatch) {
        return toAjax(bookBatchService.updateBookBatch(bookBatch));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('book:batch:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(bookBatchService.deleteBookBatchByIds(ids));
    }
}
