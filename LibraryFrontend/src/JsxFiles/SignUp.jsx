import NavBar from "./NavBar"
import form from "../cssFiles/signup.module.css";
import {Link} from "react-router-dom"

import {useRef} from 'react'

export default function SingUp(){
    const firstnameRef = useRef();
    const lastnameRef = useRef();
    const emailRef =useRef();
    const passwordRef = useRef();

    function handleSubmit(e){
        e.preventDefault();
        const formdata= {
            firstName:firstnameRef.current.value,
            lastName:lastnameRef.current.value,
            email:emailRef.current.value,
            password:passwordRef.current.value
        }
        try{
            const response = fetch("http://localhost:8080/User/signup",{
                method:"POST",
                headers:{
                    "Content-Type":"application/json"
                },
                body:JSON.stringify(formdata)
            });
            response.then(res=>console.log(res));
        }catch(error){
            console.log("error",error);
        }
    }
    return (
        <div>
            <NavBar></NavBar>
            <div className={form.signupform} >
                <h2 style={{textAlign:"center"}}>SignUp User</h2>
                <form className="row g-3 needs-validation"  onSubmit={(e)=>handleSubmit(e)}>
                    <div className="col-md-6">
                        <label  htmlFor="validationCustom01" className="form-label">First name</label>
                        <input type="text" className="form-control" id="validationCustom01" name="firstName" ref={firstnameRef}  required/>
                        <div className="valid-feedback">
                        Looks good!
                        </div>
                    </div>
                    <div className="col-md-6">
                        <label htmlFor="validationCustom02" className="form-label">Last name</label>
                        <input type="text" className="form-control" id="validationCustom02" name="lastName"  ref={lastnameRef} required/>
                        <div className="valid-feedback">
                        Looks good!
                        </div>
                    </div>
                    <div className="col-md-12">
                        <label htmlFor="validationCustom03" className="form-label">Email</label>
                        <input type="email" className="form-control" id="validationCustom03" name="email" ref={emailRef}  required/>
                        <div className="invalid-feedback">
                         enter valid email..
                        </div>
                    </div>
                     <div className="col-md-12">
                        <label htmlFor="validationCustom04" className="form-label">Password</label>
                        <input type="password" className="form-control" id="validationCustom04" name="password" ref={passwordRef}  required/>
                        <div className="invalid-feedback">
                        Looks good!
                        </div>
                    </div>

                    
                    
                    <div className="col-12" style={{textAlign:"center"}}>
                        <button className ="btn btn-primary" type="submit" style={{width:"150px",fontSize:"20px"}}>SignUp</button>
                    </div>
                    <div className="col-12"  style={{display:"flex",gap:"50px", alignItems:"center"}}>
                        <p style={{fontSize:"20px",margin:"0px"}}>if Already SignUp</p>
                        <Link className={form.link}>LogIn here</Link>
                    </div>
                </form>
            </div>
        </div>
    )
}