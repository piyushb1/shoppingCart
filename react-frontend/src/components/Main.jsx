import React, {useState} from "react";
import { Link, useHistory } from "react-router-dom";
import './css/Main.css'

const Main = () => {

    // const [joined, setJoined] = useState("");
    // const history = useHistory();


    // const join = (e) =>{
    //     e.preventDefault();
    //     if(joined !== ""){
    //         let today = new Date();
    //         let date = today.getFullYear()+ '-' +(today.getMonth()+1) + '-' + today.getDate();
    //         history.push(`/thanks/${joined}`, date );
    //     }

    // }



    return(
        <React.Fragment>
            
            <header style={{backgroundImage: `url("https://www.webfx.com/blog/images/assets/cdn.sixrevisions.com/0554-26-big-background-image-founded.jpg")`  }}>
                {/* <img  src ={`images/background.png`}/> */}
                <div>
                    <h1>We build &amp; design <br/> web applications.</h1>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin luctus congue dignissim. Vestibulum et ex nisl. Vestibulum eu luctus nisi. Fusce sit amet vehicula nisl. </p>
                    {/* <Link to="/contact">Get in touch</Link> */}
                </div>
          
            </header>


            <main>
                <div>
                <section className="services">
                     <h2>Why we should work together?</h2>

                     <div className="service-container">
                         <div className="services-card service-one"></div>
                         <div className="service-description">

                            <h3>SEO Friendly Apps.</h3>
                            <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse tincidunt massa sem. Vestibulum quis augue ac orci bibendum pellentesque ut nec dolor. Quisque metus ipsum, pulvinar quis ipsum quis, consequat cursus leo. Suspendisse fermentum, nisl et ultricies blandit, mauris metus accumsan mauris, sit amet vulputate elit nunc id libero. Vivamus porta lacus libero, et ullamcorper est volutpat ac. Maecenas eros urna, interdum in lectus nec, tristique semper mauris. Duis finibus nunc sed nulla bibendum, ut ornare tellus finibus. Donec id magna risus.</div>

                         </div>
                    </div>



                    <div className="service-container">
                      
                      <div className="services-card service-two"></div>
                      <div className="service-description">
                          <h3>Clear &amp; Optimized Code.</h3>
                          <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse tincidunt massa sem. Vestibulum quis augue ac orci bibendum pellentesque ut nec dolor. Quisque metus ipsum, pulvinar quis ipsum quis, consequat cursus leo. Suspendisse fermentum, nisl et ultricies blandit, mauris metus accumsan mauris, sit amet vulputate elit nunc id libero. Vivamus porta lacus libero, et ullamcorper est volutpat ac. Maecenas eros urna, interdum in lectus nec, tristique semper mauris. Duis finibus nunc sed nulla bibendum, ut ornare tellus finibus. Donec id magna risus.</div>
                      </div>
                    </div>



                    <div className="service-container">
                        <div className="services-card service-three"></div>
                        <div className="service-description">
                            <h3>Support 24 hours.</h3>
                            <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse tincidunt massa sem. Vestibulum quis augue ac orci bibendum pellentesque ut nec dolor. Quisque metus ipsum, pulvinar quis ipsum quis, consequat cursus leo. Suspendisse fermentum, nisl et ultricies blandit, mauris metus accumsan mauris, sit amet vulputate elit nunc id libero. Vivamus porta lacus libero, et ullamcorper est volutpat ac. Maecenas eros urna, interdum in lectus nec, tristique semper mauris. Duis finibus nunc sed nulla bibendum, ut ornare tellus finibus. Donec id magna risus.</div>
                        </div>
                      
                    </div>
                </section>

                <section>
                    <h2>Join our newsletter to get the latest trends.</h2>

                    <form className="newsletter" >
                        <input type="email" placeholder="Your email goes here" />
                        <input type="submit"  value="Join Now!"/>
                    </form>

                </section>
                </div>
            </main>


        </React.Fragment>
    )
}


export default Main;