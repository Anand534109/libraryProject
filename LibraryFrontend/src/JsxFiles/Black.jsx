import media from "../cssFiles/social.module.css"

export default function Black(){
    return (
        <div className={media.black} style={{width:"100vw", border:"2px solid black"}}>
            <h1>Start Reading Today</h1>
            <p>Join thousands of book lovers and get unlimited access to our entire collection.</p>
            <p> Your first month is free!</p>
            <div>
                <button className={`btn btn-outline-light`}>Get Start Free</button>
                <button className={`btn btn-outline-light`}>LearnMore</button>
            </div>
        </div>
    )
}