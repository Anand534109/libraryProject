import NavBar from "./NavBar";
import Banner from "./Banner";
import BookSection from "./BookSection";
import Faq from "./Faq";
import Footer from "./Footer";
import Black from "./Black";

import { useEffect,useState } from "react";
import FavrateList from "./FavrateList";



function Home(){
    const[data,setData] =useState();
    useEffect(()=>{
        fetch("http://localhost:8083/Book/googlebooks/story")
        .then(res=> res.json())
        .then(data=>setData(data))
    },[])
   
        

    return (

        <div>
            <NavBar></NavBar>
            <Banner></Banner>
            <BookSection text="Books...." data={data}></BookSection>
            <Faq></Faq><br />
            <Black></Black>
            <Footer></Footer>

            {/* <FavrateList/> */}
        </div>
    )
}

export default Home;