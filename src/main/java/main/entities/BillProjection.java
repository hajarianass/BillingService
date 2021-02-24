package main.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.OneToMany;

import org.springframework.data.rest.core.config.Projection;


@Projection(name = "fullBill",types =Bill.class)
public interface BillProjection {
	public Long getId();
	public Date getBillingDate();
	public Long getCustomerID();
	public Collection<ProductItem> getProductItems();
}
