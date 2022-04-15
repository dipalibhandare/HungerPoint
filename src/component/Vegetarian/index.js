import React from "react";
import "./vegetarian.css";
import Filter from "../common/Filter";
import DeliveryCollections from "./DeliveryCollections";
import ExploreSection from "../common/exploreSection";
import {restaurants} from "../../data/restaurants";
import MenuList from "../../data/menu";

const deliveryfilter=[
    {
        id:1,
        icon:<i className="fi fi-rr-settings-sliders absolute-center"></i>,
        title:"Filter"
    },
    {
        id:2,
        title:"Rating"
    },
    {
        id:3,
        title:"Delivery Time"
    },
    {
        id:4,
        title:"Great Offers"
    }
];
const restaurantlist = JSON.parse(localStorage.getItem('MenuList'));

const Vegetarian=()=>{
    return(
        <div>
            <div className="max-width">
            {/* <Filter filterlist={deliveryfilter}/> */}
            </div>
            <DeliveryCollections/>
            <ExploreSection list={restaurantlist}/>
            
        </div>
    );
};

export default Vegetarian;