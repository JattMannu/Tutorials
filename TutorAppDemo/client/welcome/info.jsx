import React from 'react';
import ReactDOM from 'react-dom';
import bootstrap from './../css/bootstrap.css'
import pages from './../css/pages.css'

export default class Info extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className="col-lg-12">
                <hr />

                <p className="lead" style={{ fontWeight: "900" }}>Active Tutors:</p>

                <ol>
                    <li>
                        200 new tutors every week. You will always have new tutors to choose from.
                    </li>
                    <li>
                        See reviews of tutors from other coordinators, post reviews about your good and bad experiences with our tutors.
                    </li>
                    <li>
                        Flag tutors who are no longer teaching so that you no longer have to waste time calling in the future.
                    </li>
                    <li>
                        Our tutors are able to update or delete their profiles real time so all tutors are currently looking for assignments. This is something unique to our database.
                    </li>
                </ol>

            </div >
        );
    }

}