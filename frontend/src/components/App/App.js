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
                    <div className="container">
                        <Route path={"/products/add"} exact render={() =>
                            <ProductAdd categories={this.state.categories}
                                        manufacturers={this.state.manufacturers}
                                        onAddProduct={this.addProduct}/>}/>
                        <Route path={"/products/edit/:id"} exact render={() =>
                            <ProductEdit categories={this.state.categories}
                                         manufacturers={this.state.manufacturers}
                                         onEditProduct={this.editProduct}
                                         product={this.state.selectedProduct}/>}/>
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

    loadCategories = () => {
        EShopService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            });
    }

    deleteProduct = (id) => {
        EShopService.deleteProduct(id)
            .then(() => {
                this.loadProducts();
            });
    }

    addProduct = (name, price, quantity, category, manufacturer) => {
        EShopService.addProduct(name, price, quantity, category, manufacturer)
            .then(() => {
                this.loadProducts();
            });
    }

    getProduct = (id) => {
        EShopService.getProduct(id)
            .then((data) => {
                this.setState({
                    selectedProduct: data.data
                })
            })
    }

    editProduct = (id, name, price, quantity, category, manufacturer) => {
        EShopService.editProduct(id, name, price, quantity, category, manufacturer)
            .then(() => {
                this.loadProducts();
            });
    }
}

export default App;
