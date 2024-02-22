package com.ruoyi.books.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 图书信息对象 book_info
 *
 * @author ruoyi
 * @date 2024-02-20
 */
public class BookInfo extends BaseEntity
        {
private static final long serialVersionUID=1L;

    /** 主键 */
    private Long id;

    /** 书号 */
            @Excel(name = "书号")
    private String bookeCode;

    /** 书名 */
            @Excel(name = "书名")
    private String bookName;

    /** 分类 */
            @Excel(name = "分类")
    private String bookClassification;

    /** 简介 */
            @Excel(name = "简介")
    private String bookIntroduction;

    /** 零售价格 */
            @Excel(name = "零售价格")
    private BigDecimal retailPrice;

    /** 出版社 */
            @Excel(name = "出版社")
    private String publishingHouse;

    /** 出版日期 */
            @JsonFormat(pattern = "yyyy-MM-dd")
            @Excel(name = "出版日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date publicationDate;

    /** 状态（0正常 1停用） */
            @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setId(Long id)
            {
            this.id = id;
            }

    public Long getId()
            {
            return id;
            }
    public void setBookeCode(String bookeCode)
            {
            this.bookeCode = bookeCode;
            }

    public String getBookeCode()
            {
            return bookeCode;
            }
    public void setBookName(String bookName)
            {
            this.bookName = bookName;
            }

    public String getBookName()
            {
            return bookName;
            }
    public void setBookClassification(String bookClassification)
            {
            this.bookClassification = bookClassification;
            }

    public String getBookClassification()
            {
            return bookClassification;
            }
    public void setBookIntroduction(String bookIntroduction)
            {
            this.bookIntroduction = bookIntroduction;
            }

    public String getBookIntroduction()
            {
            return bookIntroduction;
            }
    public void setRetailPrice(BigDecimal retailPrice)
            {
            this.retailPrice = retailPrice;
            }

    public BigDecimal getRetailPrice()
            {
            return retailPrice;
            }
    public void setPublishingHouse(String publishingHouse)
            {
            this.publishingHouse = publishingHouse;
            }

    public String getPublishingHouse()
            {
            return publishingHouse;
            }
    public void setPublicationDate(Date publicationDate)
            {
            this.publicationDate = publicationDate;
            }

    public Date getPublicationDate()
            {
            return publicationDate;
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
            .append("bookeCode",getBookeCode())
            .append("bookName",getBookName())
            .append("bookClassification",getBookClassification())
            .append("bookIntroduction",getBookIntroduction())
            .append("retailPrice",getRetailPrice())
            .append("publishingHouse",getPublishingHouse())
            .append("publicationDate",getPublicationDate())
            .append("status",getStatus())
            .append("createBy",getCreateBy())
            .append("createTime",getCreateTime())
            .append("updateBy",getUpdateBy())
            .append("remark",getRemark())
        .toString();
        }
        }
