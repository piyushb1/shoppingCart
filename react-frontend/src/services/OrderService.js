import axios from 'axios';
import CartService from './CartService';

const ORDER_API_BASE_URL = "http://localhost:8092/";

class OrderService {

    cart=[];

    getOrders(){
        return axios.get("http://localhost:8099/orders/getAll",{
            headers:{
            Authorization: `Bearer ${localStorage.jwtToken}`
        }});
    }

    createCart(cart){
        return axios.post(ORDER_API_BASE_URL, cart);
    }

    placeOrder(order){
        return axios.post(ORDER_API_BASE_URL+'placeOrder/', order);

        // CartService.getCartById(cartid).then((res) => {
        //     this.cart = res.data;
        //     console.log('cart => ' + JSON.stringify(this.cart));

        //     return axios.post(ORDER_API_BASE_URL+'placeOrder/', this.cart);
        // });
    }

    setAddress(address){
        return axios.post(ORDER_API_BASE_URL + 'setAddress/' ,address);
    }

    getOrderById(orderid){
        return axios.get(ORDER_API_BASE_URL + 'getorderid/' + orderid);
    }

    getOrdersById(profileid){
        return axios.get(ORDER_API_BASE_URL + 'getoBycust/' + profileid);
    }

    updateCart(cart, cartId){
        return axios.put(ORDER_API_BASE_URL + 'update/' + cartId, cart);
    }

    deleteCart(cartId){
        return axios.delete(ORDER_API_BASE_URL + 'delete/' + cartId);
    }
}

export default new OrderService()