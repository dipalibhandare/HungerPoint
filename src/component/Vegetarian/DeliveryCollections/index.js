import React from "react";
import Slider from "react-slick";
import NextArrow from "../../common/carousel/nextArrow";
import PrevArrow from "../../common/carousel/prevArrow";
import "./deliverycollections.css";
import DeliveryItem from "./DeliveryItem";

const DeliveryCollections=()=>{

    const deliveryitem=[
        {
            id:1,
            title:"veg biryani",
            cover:"https://b.zmtcdn.com/data/dish_images/d19a31d42d5913ff129cafd7cec772f81639737697.png"
        },
        {
            id:2,
            title:"Paneer Kofta",
            cover:"https://b.zmtcdn.com/data/dish_images/e44c42ff4b60b025225c8691ef9735b11635781903.png?output-format=webp"
        },
        {
            id:3,
            title:"Paratha",
            cover:"https://b.zmtcdn.com/data/o2_assets/2b5a5b533473aada22015966f668e30e1633434990.png"

        },
        {
            id:4,
            title:"Thalipeed",
            cover:"https://b.zmtcdn.com/data/dish_photos/d77/103ebc996b108ac0ba553e16a2e13d77.jpg"
        },
        {
            id:5,
            title:"Pizza",
            cover:"https://b.zmtcdn.com/data/homepage_dish_data/4/7cf2db5ec261a0fa27a502d3196a6f60.png"
        }
    ]

    const settings = {
       
        infinite: false,
        speed: 500,
        slidesToShow: 3,
        slidesToScroll: 1,
        nextArrow: <NextArrow/> ,
        prevArrow:<PrevArrow/>
      };


return (
<div className="delivery-collections">
    <div className="max-width"> 
    
    <div className="collection-title">Love to Eat  </div>
    <Slider {...settings}>
    {deliveryitem.map((items)=>{
        return <div key={items.id}> <DeliveryItem item={items}/></div>
    })}
    </Slider>
    </div>
   
</div>)

}

export default DeliveryCollections;