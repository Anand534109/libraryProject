import facebook from '../icons/facebook.png'
import instagram from '../icons/instagram.png'
import twitter from '../icons/twitter.png'
import youtube from '../icons/youtube.png'
import media from "../cssFiles/social.module.css"

export default function SocialMedia(){
    return(
        <div className={media.container}>
            <h2>E-Book Library</h2>
            <p>Your gateway to endless stories. Discover, borrow, and explore thousands of books from our curated collection</p>
            <div className={`d-flex ${media.imageContainer}`}>
                <span><img src={facebook}  className={media.image}/></span>
                <span><img src={instagram} className={media.image} /></span>
                <span><img src={twitter} className={media.image} /></span>
                <span><img src={youtube} className={media.image} /></span>
            </div>
        </div>
    )
}