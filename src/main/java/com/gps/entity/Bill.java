package com.gps.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "bill_")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_")
    private long id;
    @Column(name = "title_")
    private String title;
    @Column(name = "bill_time_")
    private Date billTime;
    @Column(name = "type_id_")
    private long typeId;
    @Column(name = "price_")
    private double price;
    @Column(name = "explain_")
    private String explain;

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", billTime=" + billTime +
                ", typeId=" + typeId +
                ", price=" + price +
                ", explain='" + explain + '\'' +
                ", typeName='" + typeName + '\'' +
                ", date1=" + date1 +
                ", date2=" + date2 +
                '}';
    }

    /**
     * 类别名称
     *@Transient注解表示当前属性为瞬时属性,跟字段没有映射， 2只作为查询条件存在
     *
     * @return
     */
    @Transient
    private String typeName;

    /*** 开始时间:用于查询 */
    @Transient
    private Date date1;
    /*** 结束时间：用于查询 */
    @Transient
    private Date date2;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
}
