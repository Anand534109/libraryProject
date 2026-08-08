import navStyle from "../cssFiles/navbar.module.css";
import { useEffect, useRef, useState } from "react";
import { useNavigate } from "react-router-dom";




function NavBar(){
    const navigate = useNavigate();
    const [islogin,setIslogin]  = useState(false);
    const[loginUser,setLoginUser] = useState({});
    const [isOpen,SetIsOpen]=useState(false);
    function gotoShwoBooks(name){
        navigate(`/home/catagory/${name}`)
    }

    const logout = ()=>{
        fetch("http://localhost:8080/User/logoutAccount",{
            method:"POST",
            credentials:"include"
        }).then(res=>{
            if(res.ok){
                navigate("/home");
            }
        }).catch(error=>console.log("logout error => ",error))
    }

    useEffect(()=>{
       const res = fetch("http://localhost:8080/User/auth/me",{
            method:"GET",
            credentials:"include"
        });
        res.then(response=>{
            if(response.ok){
                setIslogin(true);
                return response.json();
            }throw new Error("not authenticated");
        }) 
        .then(data=>setLoginUser(data))
        .catch(error=>setIslogin(false));
    },[logout])
    
    return (
        <>
        <div className={navStyle.position}>
            <nav>
                <div className={navStyle.container}>
                    <h2>E-Book</h2>
                    <div className={navStyle.list}>
                        <ul>
                            <li className="nav-item">
                                <a className="nav-link active" aria-current="page" href="/home">Home</a>
                            </li>
                            <li className="nav-item" onClick={()=>SetIsOpen((pre)=>!pre)}>
                                <a className="nav-link active" aria-current="page" href="#">Categories</a>
                            </li>
                             <li className="nav-item">
                                <a className="nav-link active" aria-current="page" href="#">About</a>
                            </li>  
                        </ul>
                        {
                            islogin === true ? <ul>
                            <li className="nav-item">
                                <h5>{loginUser?.firstName} {loginUser?.lastName}</h5>
                            </li>
                             <li className="nav-item">
                                <a className="nav-link active" aria-current="page" href="/home/favourite">Favourite</a>
                            </li>
                             <li className={`nav-item  ${navStyle.cursor}`}>
                                <h5 onClick={()=>logout()}>logout</h5>
                            </li>
                        </ul> : 
                        <ul>
                            <li className="nav-item">
                                <a className="nav-link active" aria-current="page" href="/signup">Sign up</a>
                            </li>
                             <li className="nav-item">
                                <a className="nav-link active" aria-current="page" href="/login ">login</a>
                            </li>
                        </ul>
                        }
                    </div>
                </div>
            </nav>
        {isOpen &&
            <div className={navStyle.smallContainer}>
                <li className={navStyle.smalllist} onClick={()=>gotoShwoBooks("fiction")}>Fiction</li>
                <li className={navStyle.smalllist} onClick={()=>gotoShwoBooks("non_fiction")}>Non-Fiction</li>
                <li className={navStyle.smalllist} onClick={()=>gotoShwoBooks("animals")}>Animals</li>
                <li className={navStyle.smalllist} onClick={()=>gotoShwoBooks("education")}>Education</li>
            </div>
        }
        </div>
        </>
    )
}

export default NavBar;