import banner from "../cssFiles/Banner.module.css";
import { useRef } from "react";

function Banner(){
    const searchRef = useRef();
    function handleSubmit(event){
        event.preventDefault();

        const serchData ={
            query:searchRef.current.value
        }

        const response = fetch(`http://localhost:8083/Book/googlebooks?q=${searchRef.current.value}&max=10&index=0`,{
            method:GET,
            credentials:"include",
        })

        response.then(res=>res.json())
        .then
    }
    return(
        <div className={banner.container1}>
            <div className={banner.container2}>
                <h1>Discover Your Next </h1>
                <h1>Favorite Book</h1>
                <p>Explore our vast collection of over 50,000 books. From timeless classics to the latest bestsellers,</p>
                <p>find the perfect read for every mood.</p>
                <div>
                    <form >
                        <i></i>
                        <input type="text" name="serch" ref={searchRef} />
                        <button>Search</button>
                    </form>
                </div>
            </div>
        </div>
    )
}

export default Banner;