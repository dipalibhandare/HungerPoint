import React from "react";
import ExploreCard from "./exploreCard";
import "./exploreSection.css";

const ExploreSection=({list})=>{
return(
      <div className="max-width explore-section"> 
      <div className="explore-grid">
          {list.map((restaurant)=>{
              return <ExploreCard restaurant={restaurant} key={restaurant.menuId}/>
          })}

      </div>
      </div>
)
}

export default ExploreSection;