#遇到的问题：
#一.时区的问题
解决：在数据库连接地址后拼接上这个  &serverTimezone=GMT%2B8  地区的信息
#.jpa的问题
解决：
    在entity  上面加上@entity  @id  并确保包是  import javax.persistence.*;
#.Table 'test.hibernate_sequence' doesn't exist 问题
    主要是实体ID生产策略中没有制定策略
 需要加入下面的内容   
`  @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "ali_id")
     private Long aliId;            `
