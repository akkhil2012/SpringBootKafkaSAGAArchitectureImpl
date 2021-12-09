package org.paspao.takeaway.order.api;

import io.swagger.annotations.Api;

import org.paspao.takeaway.order.bean.HamburgerDTO;
import org.paspao.takeaway.order.bean.OrderDTO;
import org.paspao.takeaway.order.bean.type.CookingType;
import org.paspao.takeaway.order.bean.type.HamburgerType;
import org.paspao.takeaway.order.business.OrderService;
import org.paspao.takeaway.order.port.IOrderServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 06/09/19.
 */
@RestController
@RequestMapping("/order/")
@Api(tags = "OrderServices")
public class OrderApi implements IOrderServiceApi {

    @Autowired
    private OrderService orderService;

    @Override
    @PostMapping("/orderDTO")  
    public OrderDTO create(@RequestBody String name) {
    	System.out.print(" Received order........ ");
    	OrderDTO orderDTO = new OrderDTO();
    	//Hardcoded orderDTO Values here //
    	List<HamburgerDTO> hamburgerDTOList = new ArrayList<HamburgerDTO>();
    	hamburgerDTOList.add(new HamburgerDTO(HamburgerType.CHIANINA, 2));
    	hamburgerDTOList.add(new HamburgerDTO(HamburgerType.ANGUS,3));
    	
    	orderDTO.setHamburgerList(hamburgerDTOList);
    	orderDTO.setCookingType(CookingType.BLOOD);
        return orderService.createOrder(orderDTO);
    }

	/*
	 * public OrderDTO create(@RequestBody OrderDTO orderDTO) {
	 * System.out.print(" Received order........ "); return
	 * orderService.createOrder(orderDTO); }
	 */
    
    @Override
    public OrderDTO view(String id) {
        return orderService.getById(id);
    }

    @Override
    public List<OrderDTO> viewAll() {
        return orderService.getAll();
    }


}
