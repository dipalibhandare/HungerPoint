import React from "react";

const LocateMe=()=>{
    const [latitude,setLatitude]=React.useState('');
    const[longitute,setLogitute]=React.useState('');

React.useEffect(()=>{
    navigator.geolocation.getCurrentPosition((position)=>{
        setLatitude(position.coords.latitude);
        setLogitute(position.coords.longitude);

    })

    
})
return <div>This is current location</div>
}

export default LocateMe;