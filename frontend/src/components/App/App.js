import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import Products from '../Products/ProductsList/products';
import Header from '../Header/header';
import ProductAdd from '../Products/ProductsAdd/productAdd';
import EShopService from "../../repository/eshopRepository";
import ProductEdit from "../Products/ProductsEdit/productEdit";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            products: [],
            selectedProduct: {}
        }
    }

    render() {
        return (
            <Router>
                <Header/>
                <main>
                    <div className="container">>
                        <Route path={"/products"} exact render={() =>
                            <Products products={this.state.products}
                                      onDelete={this.deleteProduct}
                                      onEdit={this.getProduct}/>}/>
                        <Redirect to={"/products"}/>
                    </div>
                </main>
            </Router>
        );
    }

    componentDidMount() {
        this.loadProducts();
    }


    loadProducts = () => {
        EShopService.fetchProducts()
            .then((data) => {
                this.setState({
                    products: data.data
                })
            });
    }
}

export default App;
