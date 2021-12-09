package org.paspao.takeaway.order.dao;

import org.paspao.takeaway.order.entity.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on
 * 06/09/19.
 */

public interface OrderRepository extends MongoRepository<Order, String> {

	

}
