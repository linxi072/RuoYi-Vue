package com.ruoyi.books.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 进书批次对象 book_batch
 *
 * @author ruoyi
 * @date 2024-02-20
 */
public class BookBatch extends BaseEntity
        {
private static final long serialVersionUID=1L;

    /** 主键 */
    private Long id;

    /** 批次名称 */
            @Excel(name = "批次名称")
    private String batchName;

    /** 总金额 */
            @Excel(name = "总金额")
    private BigDecimal sumAmount;

    /** 批次状态 */
            @Excel(name = "批次状态")
    private String status;

    /** 下单时间 */
            @JsonFormat(pattern = "yyyy-MM-dd")
            @Excel(name = "下单时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderTime;

    /** 支付时间 */
            @JsonFormat(pattern = "yyyy-MM-dd")
            @Excel(name = "支付时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date payTime;

    /** 签收时间 */
            @JsonFormat(pattern = "yyyy-MM-dd")
            @Excel(name = "签收时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date sendTime;

    public void setId(Long id)
            {
            this.id = id;
            }

    public Long getId()
            {
            return id;
            }
    public void setBatchName(String batchName)
            {
            this.batchName = batchName;
            }

    public String getBatchName()
            {
            return batchName;
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
    public void setOrderTime(Date orderTime)
            {
            this.orderTime = orderTime;
            }

    public Date getOrderTime()
            {
            return orderTime;
            }
    public void setPayTime(Date payTime)
            {
            this.payTime = payTime;
            }

    public Date getPayTime()
            {
            return payTime;
            }
    public void setSendTime(Date sendTime)
            {
            this.sendTime = sendTime;
            }

    public Date getSendTime()
            {
            return sendTime;
            }

@Override
public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id",getId())
            .append("batchName",getBatchName())
            .append("sumAmount",getSumAmount())
            .append("status",getStatus())
            .append("orderTime",getOrderTime())
            .append("payTime",getPayTime())
            .append("sendTime",getSendTime())
        .toString();
        }
        }
