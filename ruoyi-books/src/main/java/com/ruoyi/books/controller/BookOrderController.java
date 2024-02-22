package com.ruoyi.books.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.books.domain.BookOrder;
import com.ruoyi.books.service.IBookOrderService;
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
 * 进货单Controller
 *
 * @author ruoyi
 * @date 2024-02-20
 */
@RestController
@RequestMapping("/book/order")
public class BookOrderController extends BaseController {
    @Autowired
    private IBookOrderService bookOrderService;

/**
 * 查询进货单列表
 */
@PreAuthorize("@ss.hasPermi('book:order:list')")
@GetMapping("/list")
    public TableDataInfo list(BookOrder bookOrder) {
        startPage();
        List<BookOrder> list = bookOrderService.selectBookOrderList(bookOrder);
        return getDataTable(list);
    }

    /**
     * 导出进货单列表
     */
    @PreAuthorize("@ss.hasPermi('book:order:export')")
    @Log(title = "进货单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BookOrder bookOrder) {
        List<BookOrder> list = bookOrderService.selectBookOrderList(bookOrder);
        ExcelUtil<BookOrder> util = new ExcelUtil<BookOrder>(BookOrder. class);
        util.exportExcel(response, list, "进货单数据");
    }

    /**
     * 获取进货单详细信息
     */
    @PreAuthorize("@ss.hasPermi('book:order:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(bookOrderService.selectBookOrderById(id));
    }

    /**
     * 新增进货单
     */
    @PreAuthorize("@ss.hasPermi('book:order:add')")
    @Log(title = "进货单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BookOrder bookOrder) {
        return toAjax(bookOrderService.insertBookOrder(bookOrder));
    }

    /**
     * 修改进货单
     */
    @PreAuthorize("@ss.hasPermi('book:order:edit')")
    @Log(title = "进货单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BookOrder bookOrder) {
        return toAjax(bookOrderService.updateBookOrder(bookOrder));
    }

    /**
     * 删除进货单
     */
    @PreAuthorize("@ss.hasPermi('book:order:remove')")
    @Log(title = "进货单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(bookOrderService.deleteBookOrderByIds(ids));
    }
}
