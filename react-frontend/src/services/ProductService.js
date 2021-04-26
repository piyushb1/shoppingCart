import axios from 'axios';

const USER_API = "http://localhost:8093/";

class ProductService {

    getProducts(){
        return axios.get(USER_API + 'getAll');
    }

    createProduct(product){
        return axios.post(USER_API+ 'create' , product);
    }

    getProductById(productId){
        return axios.get(USER_API + 'getId/' + productId);
    }

    updateProduct(product, productId){
        return axios.put(USER_API + 'update/' + productId, product);
    }

    deleteProduct(productId){
        return axios.delete(USER_API + 'delete/' + productId);
    }
}

export default new ProductService();