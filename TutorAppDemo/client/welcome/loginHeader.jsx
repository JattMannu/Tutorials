import React from 'react';
import ReactDOM from 'react-dom';
import bootstrap from './../css/bootstrap.css'
import pages from './../css/pages.css'
import Login from './login.jsx'

export default class LoginHeader extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className="row" style={{
                backgroundImage: "url(https://manytutors.com/assets/img/background-coor1.jpg)",
                backgroundSize: "cover",
                marginTop: "-75px",
                backgroundPosition: "right top"
            }}>
                < div className="col-lg-4 col-md-5 col-sm-8 col-sm-offset-2 col-md-offset-0" >
                    <div className="panel panel-transparent">
                        <div className="panel-heading">
                            <h2 style={{ color: "white", fontWeight: 500 }}>
                                Tutor Database for Coordinators<br />
                                Reach 100,000 tutors.
                                <p style={{
                                    color: "white",
                                    fontWeight: "500"
                                }}>
                                    Want to be a tuition coordinator or a tuition agent?
                                </p>
                            </h2>
                        </div>
                        <Login />
                    </div>
                </div >
            </div >
        );
    }
}