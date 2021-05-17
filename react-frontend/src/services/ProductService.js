import axios from 'axios';

const USER_API = "http://localhost:8093/";

const headers = {
    'Authorization': 'Bearer '+localStorage.jwtToken
};

class ProductService {

    getProducts(){
        console.log('headers => ' + JSON.stringify(headers));

        return axios.get("http://localhost:8099/getAll");
    }

    createProduct(product){
        return axios.post(USER_API+ 'create' , product);
    }

    async getProductById(productId){
        return axios.get(USER_API + 'getId/' + productId);
        // const res = await axios.get( "http://localhost:8093/getId/" + productId, {
        //     headers: {
        //         'Authorization': 'Bearer ' + localStorage.jwtToken
        //     }
        // });
        // return console.log('product => ' + JSON.stringify(res.data));
    }

    updateProduct(product, productId){
        return axios.put(USER_API + 'update/' + productId, product);
    }

    deleteProduct(productId){
        return axios.delete(USER_API + 'delete/' + productId);
    }
}

export default new ProductService();