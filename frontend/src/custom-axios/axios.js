import axios from "axios";

const instance = axios.create({
    baseURL: 'http://localhost:8083/api',
    headers: {
        'Access-Control-Allow-Origin' : '*'
    }
});

/* const instanceOrders = axios.create({
    baseURL: 'http://localhost:8084/api',
    headers: {
        'Access-Control-Allow-Origin' : '*'
    }
}); */

export {
   instance
};