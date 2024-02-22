package com.ruoyi.books.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 进货单对象 book_order
 *
 * @author ruoyi
 * @date 2024-02-20
 */
public class BookOrder extends BaseEntity
        {
private static final long serialVersionUID=1L;

    /** $column.columnComment */
    private Long id;

    /** 批次id */
            @Excel(name = "批次id")
    private Long batchId;

    /** 图书id */
            @Excel(name = "图书id")
    private Long bookId;

    /** 数量 */
            @Excel(name = "数量")
    private Long num;

    /** 支付金额 */
            @Excel(name = "支付金额")
    private BigDecimal amount;

    /** 总金额 */
            @Excel(name = "总金额")
    private BigDecimal sumAmount;

    /** 状态（0正常 1关闭） */
            @Excel(name = "状态", readConverterExp = "0=正常,1=关闭")
    private String status;

    public void setId(Long id)
            {
            this.id = id;
            }

    public Long getId()
            {
            return id;
            }
    public void setBatchId(Long batchId)
            {
            this.batchId = batchId;
            }

    public Long getBatchId()
            {
            return batchId;
            }
    public void setBookId(Long bookId)
            {
            this.bookId = bookId;
            }

    public Long getBookId()
            {
            return bookId;
            }
    public void setNum(Long num)
            {
            this.num = num;
            }

    public Long getNum()
            {
            return num;
            }
    public void setAmount(BigDecimal amount)
            {
            this.amount = amount;
            }

    public BigDecimal getAmount()
            {
            return amount;
            }
    public void setSumAmount(BigDecimal sumAmount)
            {
            this.sumAmount = sumAmount;
            }

    public BigDecimal getSumAmount()
            {
            return sumAmount;
            }
    public void setStatus(String status)
            {
            this.status = status;
            }

    public String getStatus()
            {
            return status;
            }

@Override
public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id",getId())
            .append("batchId",getBatchId())
            .append("bookId",getBookId())
            .append("num",getNum())
            .append("amount",getAmount())
            .append("sumAmount",getSumAmount())
            .append("status",getStatus())
            .append("createBy",getCreateBy())
            .append("createTime",getCreateTime())
            .append("updateBy",getUpdateBy())
            .append("updateTime",getUpdateTime())
            .append("remark",getRemark())
        .toString();
        }
        }
