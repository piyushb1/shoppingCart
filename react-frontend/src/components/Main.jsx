import React, {useState} from "react";
import { Link, useHistory } from "react-router-dom";
import './css/Main.css'

const Main = () => {

    


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

            <div>
                
                <div id="carousel-example-1z" class="carousel slide carousel-fade pt-4" data-ride="carousel">
                    <ol class="carousel-indicators">
                    <li data-target="#carousel-example-1z" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-1z" data-slide-to="1"></li>
                    <li data-target="#carousel-example-1z" data-slide-to="2"></li>
                    </ol>    <div class="carousel-inner" role="listbox">
                    <div class="carousel-item active">
                        <div class="view" style="background-image: url('https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/8-col/img%282%29.jpg'); background-repeat: no-repeat; background-size: cover;">
                        <div class="mask rgba-black-strong d-flex justify-content-center align-items-center">

                            <div class="text-center white-text mx-5 wow fadeIn">
                            <h1 class="mb-4">
                                <strong>Learn Bootstrap 4 with MDB</strong>
                            </h1>

                            <p>
                                <strong>Best & free guide of responsive web design</strong>
                            </p>

                            <p class="mb-4 d-none d-md-block">
                                <strong>The most comprehensive tutorial for the Bootstrap 4. Loved by over 500 000 users. Video and written versions
                                available. Create your own, stunning website.</strong>
                            </p>

                            <a target="_blank" href="https://mdbootstrap.com/education/bootstrap/" class="btn btn-outline-white btn-lg">Start free tutorial
                                <i class="fas fa-graduation-cap ml-2"></i>
                            </a>
                            </div>

                        </div>

                        </div>
                    </div>

                    <div class="carousel-item">
                        <div class="view" style="background-image: url('https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/8-col/img%283%29.jpg'); background-repeat: no-repeat; background-size: cover;">

                        <div class="mask rgba-black-strong d-flex justify-content-center align-items-center">

                            <div class="text-center white-text mx-5 wow fadeIn">
                            <h1 class="mb-4">
                                <strong>Learn Bootstrap 4 with MDB</strong>
                            </h1>

                            <p>
                                <strong>Best & free guide of responsive web design</strong>
                            </p>

                            <p class="mb-4 d-none d-md-block">
                                <strong>The most comprehensive tutorial for the Bootstrap 4. Loved by over 500 000 users. Video and written versions
                                available. Create your own, stunning website.</strong>
                            </p>

                            <a target="_blank" href="https://mdbootstrap.com/education/bootstrap/" class="btn btn-outline-white btn-lg">Start free tutorial
                                <i class="fas fa-graduation-cap ml-2"></i>
                            </a>
                            </div>

                        </div>

                        </div>
                    </div>

                    <div class="carousel-item">
                        <div class="view" style="background-image: url('https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/8-col/img%285%29.jpg'); background-repeat: no-repeat; background-size: cover;">

                        <div class="mask rgba-black-strong d-flex justify-content-center align-items-center">

                            <div class="text-center white-text mx-5 wow fadeIn">
                            <h1 class="mb-4">
                                <strong>Learn Bootstrap 4 with MDB</strong>
                            </h1>

                            <p>
                                <strong>Best & free guide of responsive web design</strong>
                            </p>

                            <p class="mb-4 d-none d-md-block">
                                <strong>The most comprehensive tutorial for the Bootstrap 4. Loved by over 500 000 users. Video and written versions
                                available. Create your own, stunning website.</strong>
                            </p>

                            <a target="_blank" href="https://mdbootstrap.com/education/bootstrap/" class="btn btn-outline-white btn-lg">Start free tutorial
                                <i class="fas fa-graduation-cap ml-2"></i>
                            </a>
                            </div>

                        </div>

                        </div>
                    </div>

                    </div>

                    <a class="carousel-control-prev" href="#carousel-example-1z" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carousel-example-1z" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                    </a>

                </div>



            </div>


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