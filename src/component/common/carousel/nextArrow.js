import React from "react";

const NextArrow=(props)=>{
    const {className,style,onclick}=props;
   return (
   <div className={className}
   style={{...style,borderRadius:'50%',background:'white',
   display:'flex',
   justifyContent:'center',
   alignItems:'center',
   padding:'4px'}}
   onClick={onclick}
   >


   </div>
   )
}

export default NextArrow;