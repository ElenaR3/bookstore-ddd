import axios from '../custom-axios/axios';

const EShopService = {

    fetchProducts: () => {
        return axios.get("/product");  //  localhost:8083/api/product
    },

    getProduct: (id) => {
        return axios.get(`/products/${id}`);
    }
}

export default EShopService;
