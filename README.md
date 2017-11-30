# Struts2_Hibernate_BookManage
# 由Maven构建
# 建立相应的数据库即可运行
<session-factory >

	<property name="connection.username">root</property>
	
	<property name="connection.password">root</property>
	
	<property name="connection.driver_class">com.mysql.jdbc.Driver</property>
	
	<property name="connection.url">jdbc:mysql://localhost:3306/wzx</property>
	
	<property name="dialect">org.hibernate.dialect.MySQL5Dialect</property>
	
	<property name="show_sql">true</property>
	
	<property name="format_sql">true</property>
	
	<property name="hbm2ddl.auto">update</property>
	
	<property name="hibernate.current_session_context_class">thread</property> 
	
	<mapping resource="entity/Book.hbm.xml"/>
	
	</session-factory>
