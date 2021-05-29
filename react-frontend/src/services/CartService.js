import axios from 'axios';
import ProductService from './ProductService';

const CART_API_BASE_URL = "http://localhost:8091/";

class CartService {

    product=[];

    getCarts(){
        return axios.get(CART_API_BASE_URL+'getAll');
    }

    createCart(cart){
        return axios.post(CART_API_BASE_URL, cart);
    }

    addToCart(userid,productid){
        ProductService.getProductById(productid).then((res) => {
            this.product = res.data;
            console.log('product => ' + JSON.stringify(this.product));

            let item = {
                productid: this.product.productid, 
                productName: this.product.productName,
                price: this.product.price,
                quantity: 1
            };

            console.log('item => ' + JSON.stringify(item));

            return axios.post(CART_API_BASE_URL+'addItem/'+userid, item);
        });
    }

    getCartById(cartId){
        return axios.get(CART_API_BASE_URL + 'get/' + cartId);
    }

    removeitem(productid){
        ProductService.getProductById(productid).then((res) => {
            this.product = res.data;

            let item = {
                productid: this.product.productid, 
                productName: this.product.productName,
                price: this.product.price,
                quantity: 1
            };
            let userid = localStorage.userid;

            return axios.post(CART_API_BASE_URL+'removeitem/'+userid, item);
        });
    }

    updateCart(cart, cartId){
        return axios.put(CART_API_BASE_URL + 'update/' + cartId, cart);
    }

    deleteCart(cartId){
        return axios.delete(CART_API_BASE_URL + 'delete/' + cartId);
    }
}

export default new CartService()