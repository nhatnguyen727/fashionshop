package com.fashion.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fashion.models.entity.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>{
	@Query(value = "select a.id, a.quantity, a.idord, b.payment, b.status, b.date, a.idpro , b.iduser, p.name, p.unit, p.price_enter,p.price_sale,\n"
			+ "p.amountimport,p.amountsold,p.iddis,p.idsup ,p.idcate, d.value\n"
			+ "from orderdetail a inner join orders b on a.idord = b.id\n"
			+ "inner join product p on p.id = a.idpro inner join discount d on d.id = p.iddis\n"
			+ "where TIMESTAMPDIFF(month, b.date,NOW()) < 1 and LOWER(b.status) like 'đã%'",nativeQuery = true)
	List<Object> monthlyReport();
	
	@Query(value = "select a.id, a.quantity, a.idord, b.payment, b.status, b.date, a.idpro , b.iduser, p.name, p.unit, p.price_enter,p.price_sale,\n"
			+ "p.amountimport,p.amountsold,p.iddis,p.idsup ,p.idcate, d.value\n"
			+ "from orderdetail a inner join orders b on a.idord = b.id\n"
			+ "inner join product p on p.id = a.idpro inner join discount d on d.id = p.iddis\n"
			+ "where TIMESTAMPDIFF(day, b.date, NOW()) < 7 and LOWER(b.status) like 'đã%'",nativeQuery = true)
	List<Object> weeklReport();
}
