import React from 'react';
import ReactDOM from 'react-dom';
import bootstrap from './../css/bootstrap.css'
import pages from './../css/pages.css'
import style from './../css/style.css'

export default class Academic extends React.Component {
    constructor(props) {
        super(props);
        this.state = {

            LowerPrimaryView: false,
            UpperPrimaryView: false,
            LowerSecondaryView: false,
            UpperSecondaryView: false,
            JuniorCollegeView: false
        }
    }

    handleOnClick(e) {
        e.preventDefault();
    }

    render() {
        return (
            <div className="container-fluid" >
                <div className="tab-pane fade active in" id="academic">
                    <div className="search-wrapper active">
                        <form method="POST" action="https://manytutors.com/coordinators/search/academic" acceptCharset="UTF-8" className="search-controls-form academic">
                            <input name="_token" type="hidden" value="rjyDbdA0AewNHuTI1rXtXpmbwZk4SQAzjJ4LlnBP" />
                            <div className="search-subjects-wrapper">
                                <div className="subjects-ul">
                                    <div className="form-group">
                                        <div className="subjectsPortlet panel panel-condensed panel-default panel-collapsed">
                                            <div className="panel-heading" data-toggle="collapse" style={{ cursor: "pointer" }}>
                                                <div className="panel-title">
                                                    Lower Primary
                                                </div>
                                                <div className="panel-controls">
                                                    <ul>
                                                        <li>
                                                            <a href="https://manytutors.com/coordinators/dashboard#" className="portlet-collapse">
                                                                <i className="pg-arrow_minimize"></i>
                                                            </a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div className="panel-body" style={{ display: "none" }}>
                                                <ul className="list-unstyled list-inline clearfix">
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="1" id="1" />
                                                            <label htmlFor="1">English</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="2" id="2" />
                                                            <label htmlFor="2">Chinese</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="3" id="3" />
                                                            <label htmlFor="3">Malay</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="4" id="4" />
                                                            <label htmlFor="4">Tamil</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="5" id="5" />
                                                            <label htmlFor="5">Maths</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="6" id="6" />
                                                            <label htmlFor="6">Science</label>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </div>
                                            <img src="./client/img/progress-circle-master.svg" style={{ display: "none" }} />
                                            <img src="./client/img/progress-circle-master.svg" style={{ display: "none" }} />
                                        </div>
                                    </div>
                                    <div className="form-group">
                                        <div className="subjectsPortlet panel panel-condensed panel-default panel-collapsed">
                                            <div className="panel-heading" data-toggle="collapse" style={{ cursor: "pointer" }}>
                                                <div className="panel-title">
                                                    Upper Primary
                                                </div>
                                                <div className="panel-controls">
                                                    <ul>
                                                        <li>
                                                            <a href="https://manytutors.com/coordinators/dashboard#" className="portlet-collapse">
                                                                <i className="pg-arrow_minimize"></i>
                                                            </a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div className="panel-body" style={{ display: "none" }}>
                                                <ul className="list-unstyled list-inline clearfix">
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="7" id="7" />
                                                            <label htmlFor="7">English</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="8" id="8" />
                                                            <label htmlFor="8">Chinese</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="9" id="9" />
                                                            <label htmlFor="9">Malay</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="10" id="10" />
                                                            <label htmlFor="10">Tamil</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="11" id="11" />
                                                            <label htmlFor="11">Maths</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="12" id="12" />
                                                            <label htmlFor="12">Science</label>
                                                        </div>
                                                    </li>

                                                </ul>

                                            </div>
                                            <img src="./client/img/progress-circle-master.svg" style={{ display: "none" }} />
                                            <img src="./client/img/progress-circle-master.svg" style={{ display: "none" }} />
                                        </div>
                                    </div>
                                    <div className="form-group">
                                        <div className="subjectsPortlet panel panel-condensed panel-default panel-collapsed">
                                            <div className="panel-heading" data-toggle="collapse" style={{ cursor: "pointer" }}>
                                                <div className="panel-title">
                                                    Lower Secondary
                                                </div>
                                                <div className="panel-controls">
                                                    <ul>
                                                        <li>
                                                            <a href="https://manytutors.com/coordinators/dashboard#" className="portlet-collapse">
                                                                <i className="pg-arrow_minimize"></i>
                                                            </a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div className="panel-body" style={{ display: "none" }}>
                                                <ul className="list-unstyled list-inline clearfix">
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="13" id="13" />
                                                            <label htmlFor="13">English</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="14" id="14" />
                                                            <label htmlFor="14">Chinese</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="15" id="15" />
                                                            <label htmlFor="15">Malay</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="16" id="16" />
                                                            <label htmlFor="16">Tamil</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="17" id="17" />
                                                            <label htmlFor="17">Maths</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="18" id="18" />
                                                            <label htmlFor="18">Science</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="19" id="19" />
                                                            <label htmlFor="19">Literature</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="20" id="20" />
                                                            <label htmlFor="20">Geography</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="21" id="21" />
                                                            <label htmlFor="21">History</label>
                                                        </div>
                                                    </li>

                                                </ul>

                                            </div>
                                            <img src="./client/img/progress-circle-master.svg" style={{ display: "none" }} />
                                            <img src="./client/img/progress-circle-master.svg" style={{ display: "none" }} />
                                        </div>
                                    </div>
                                    <div className="form-group">
                                        <div className="subjectsPortlet panel panel-condensed panel-default">
                                            <div className="panel-heading" data-toggle="collapse" style={{ cursor: "pointer" }}>
                                                <div className="panel-title">
                                                    Upper Secondary
                                                </div>
                                                <div className="panel-controls">
                                                    <ul>
                                                        <li>
                                                            <a href="https://manytutors.com/coordinators/dashboard#" className="portlet-collapse">
                                                                <i className="pg-arrow_minimize"></i>
                                                            </a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div className="panel-body" style={{}}>
                                                <ul className="list-unstyled list-inline clearfix">
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="22" id="22" />
                                                            <label htmlFor="22">English</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="23" id="23" />
                                                            <label htmlFor="23">Chinese</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="24" id="24" />
                                                            <label htmlFor="24">Malay</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="25" id="25" />
                                                            <label htmlFor="25">Tamil</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="26" id="26" />
                                                            <label htmlFor="26">Elementary Maths</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="27" id="27" />
                                                            <label htmlFor="27">Additional Maths</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="28" id="28" />
                                                            <label htmlFor="28">Physics</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="29" id="29" />
                                                            <label htmlFor="29">Chemistry</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="30" id="30" />
                                                            <label htmlFor="30">Biology</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="31" id="31" />
                                                            <label htmlFor="31">History</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="32" id="32" />
                                                            <label htmlFor="32">Geography</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="33" id="33" />
                                                            <label htmlFor="33">Accounts</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="34" id="34" />
                                                            <label htmlFor="34">Literature</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="35" id="35" />
                                                            <label htmlFor="35">Combined Science (Phy, Chem)</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="36" id="36" />
                                                            <label htmlFor="36">Combined Science (Chem, Bio)</label>
                                                        </div>
                                                    </li>

                                                </ul>

                                            </div>
                                            <img src="./client/img/progress-circle-master.svg" style={{ display: "none" }} />
                                            <img src="./client/img/progress-circle-master.svg" style={{ display: "none" }} />
                                        </div>
                                    </div>
                                    <div className="form-group">
                                        <div className="subjectsPortlet panel panel-condensed panel-default panel-collapsed">
                                            <div className="panel-heading" data-toggle="collapse" style={{ cursor: "pointer" }}>
                                                <div className="panel-title">
                                                    Junior College
                                                </div>
                                                <div className="panel-controls">
                                                    <ul>
                                                        <li>
                                                            <a href="https://manytutors.com/coordinators/dashboard#" className="portlet-collapse">
                                                                <i className="pg-arrow_minimize"></i>
                                                            </a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div className="panel-body" style={{ display: "none" }}>
                                                <ul className="list-unstyled list-inline clearfix">
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="37" id="37" />
                                                            <label htmlFor="37">General Paper</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="38" id="38" />
                                                            <label htmlFor="38">Chinese</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="39" id="39" />
                                                            <label htmlFor="39">Malay</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="40" id="40" />
                                                            <label htmlFor="40">Tamil</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="41" id="41" />
                                                            <label htmlFor="41">Maths (H1)</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="42" id="42" />
                                                            <label htmlFor="42">Maths (H2)</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="43" id="43" />
                                                            <label htmlFor="43">Maths (H3)</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="44" id="44" />
                                                            <label htmlFor="44">Physics</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="45" id="45" />
                                                            <label htmlFor="45">Chemistry</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="46" id="46" />
                                                            <label htmlFor="46">Biology</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="47" id="47" />
                                                            <label htmlFor="47">History</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="48" id="48" />
                                                            <label htmlFor="48">Geography</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="49" id="49" />
                                                            <label htmlFor="49">Accounts</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="50" id="50" />
                                                            <label htmlFor="50">Literature</label>
                                                        </div>
                                                    </li>
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input data-name="subject-checkbox" name="subjects[]" type="checkbox" value="51" id="51" />
                                                            <label htmlFor="51">Economics</label>
                                                        </div>
                                                    </li>

                                                </ul>

                                            </div>
                                            <img src="./client/img/progress-circle-master.svg" style={{ display: "none" }} />
                                            <img src="./client/img/progress-circle-master.svg" style={{ display: "none" }} />
                                        </div>
                                    </div>
                                </div>

                                {/*                                  <style>
                                        .subjects-ul .row [class*='col-']:first-child {
                                            padding - right: 7px;
            padding-left: 7px;
        }

        .subjects-ul .form-group {
                                            margin - bottom: 0px;
            padding-bottom: 0px;
            margin-top: 0px;
            padding-top: 0px;
        }

        .subjects-ul .panel {
                                            margin - bottom: 0px;
        }

        .subjects-ul .checkbox {
                                            margin - top: 4px;
          margin-bottom: 4px;
        }

    </style>

                                    <script src="./ManyTutors Tuition Database - Be a tuition coordinator _ tuition agent_files/email-decode.min.js.download"></script><script>
                                        $(function(){
                                            $('.subjectsPortlet').portlet({
                                            });
                                        });
                                    </script>*/}
                            </div>

                            <div className="panel panel-condensed panel-default">
                                <div className="panel-heading">
                                    <div className="panel-title">
                                        Tutor's Particulars
                                    </div>
                                </div>
                                <div className="panel-body">
                                    <div className="row">
                                        <div className="col-sm-6">
                                            <div className="form-group">
                                                <label htmlFor="gender">Gender</label>
                                                <br />
                                                <select id="gender" name="gender">
                                                    <option value="both">Both</option>
                                                    <option value="female">Female</option>
                                                    <option value="male">Male</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div className="col-sm-6">
                                            <div className="form-group">
                                                <label htmlFor="race">Race</label>
                                                <br />
                                                <select id="race" name="race">
                                                    <option value="any">Any</option>
                                                    <option value="chinese">Chinese</option>
                                                    <option value="malay">Malay</option>
                                                    <option value="indian">Indian</option>
                                                    <option value="others">Others</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div className="col-sm-12">
                                            <div className="form-group">
                                                <label htmlFor="teacher_status">
                                                    Types of teacher
                                                <br />
                                                    <span className="small">
                                                        (Sign up to see school teachers)
                                                </span>
                                                </label>

                                                <ul className="list-unstyled list-inline clearfix teacher-status-ul">
                                                    <li className="col-xs-6">
                                                        <div className="checkbox check-success checkbox-circle">
                                                            <input name="teacher_status[]" type="checkbox" value="part-time tutor" id="part-time tutor" checked="checked" disabled="" />
                                                            <label htmlFor="part-time tutor">Part Time</label>
                                                        </div>
                                                        <input type="hidden" name="teacher_status[]" value="part-time tutor" />
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="row">
                                        <div className="col-sm-6">
                                            <div className="form-group">
                                                <label htmlFor="preferred_location">Preferred Location</label> <br />
                                                <select id="preferred_location" name="preferred_location">
                                                    <option value="no preference">No Preference</option>
                                                    <option value="north-east">North-East</option>
                                                    <option value="east">East</option>
                                                    <option value="west">West</option>
                                                    <option value="north">North</option>
                                                    <option value="central">Central</option>
                                                </select>
                                            </div>    </div>

                                        <div className="col-sm-6">
                                            <div className="form-group">
                                                <label htmlFor="education_level">Highest Education</label> <br />
                                                <select id="education_level" name="education_level"><option value="any">Any</option><option value="Below O Level">Below O Level</option><option value="O Level">O Level</option><option value="JC (Not Graduated)">JC (Not Graduated)</option><option value="A Level">A Level</option><option value="Polytechnic (Not Graduated)">Polytechnic (Not Graduated)</option><option value="Diploma">Diploma</option><option value="Undergraduate">Undergraduate</option><option value="Graduate">Graduate</option><option value="Post Graduate">Post Graduate</option><option value="Master Degree">Master Degree</option><option value="Phd">Phd</option><option value="Others">Others</option></select>
                                            </div>    </div>
                                    </div>


                                    <div className="row">
                                        <div className="col-sm-6">
                                            <div className="form-group">
                                                <label htmlFor="sort">Sort By</label> <br />
                                                <select style={{ width: "100 %" }} id="sort" name="sort"><option value="last_login">Last Login</option><option value="experience">Experience</option><option value="age">Age</option></select>
                                            </div>
                                        </div>
                                        <div className="col-sm-6">
                                            <div className="form-group">
                                                <label htmlFor="sort-order">Sort order</label> <br />
                                                <select style={{ width: "100 %" }} id="sort-order" name="sort-order"><option value="desc">Descending</option><option value="asc">Ascending</option></select>
                                            </div>
                                        </div>
                                    </div>

                                    <div className="row">
                                        <div className="col-md-12" >
                                            <div className="form-group form-group-default">
                                                <label htmlFor="nearest_mrt">Nearest MRT</label>
                                                <div className="select2-container form-control nearest_mrt full-width" id="s2id_nearest_mrt">
                                                    <a href="javascript:void(0)" className="select2-choice" tabIndex="-1">
                                                        <span className="select2-chosen" id="select2-chosen-1">No Preference</span>
                                                        <abbr className="select2-search-choice-close"></abbr>
                                                        <span className="select2-arrow" role="presentation">
                                                            <b role="presentation"></b>
                                                        </span>
                                                    </a>
                                                    <label htmlFor="s2id_autogen1" className="select2-offscreen">Nearest MRTNearest MRT</label>
                                                    <input className="select2-focusser select2-offscreen" type="text" aria-haspopup="true" role="button" aria-labelledby="select2-chosen-1" id="s2id_autogen1" />
                                                    <div className="select2-drop select2-display-none select2-with-searchbox">
                                                        <div className="select2-search">
                                                            <label htmlFor="s2id_autogen1_search" className="select2-offscreen">Nearest MRTNearest MRT</label>
                                                            <input type="text" autoComplete="off" autoCorrect="off" autoCapitalize="off" spellCheck="false" className="select2-input" role="combobox" aria-expanded="true" aria-autocomplete="list" aria-owns="select2-results-1" id="s2id_autogen1_search" placeholder="" />
                                                        </div>
                                                        <ul className="select2-results" role="listbox" id="select2-results-1">
                                                        </ul>
                                                    </div>
                                                </div>
                                                <select className="form-control nearest_mrt full-width select2-offscreen" id="nearest_mrt" name="nearest_mrt" tabIndex="-1" title="Nearest MRTNearest MRT">
                                                    <option value="any">No Preference</option>
                                                    <optgroup label="East West Line">
                                                        <option value="Pasir Ris">Pasir Ris</option>
                                                        <option value="Tampines">Tampines</option>
                                                        <option value="Simei">Simei</option>
                                                        <option value="Tenah Merah">Tenah Merah</option>
                                                        <option value="Bedok">Bedok</option>
                                                        <option value="Kembangan">Kembangan</option>
                                                        <option value="Eunos">Eunos</option>
                                                        <option value="Paya Lebar">Paya Lebar</option>
                                                        <option value="Aljunied">Aljunied</option>
                                                        <option value="Kallang">Kallang</option>
                                                        <option value="Lavender">Lavender</option>
                                                        <option value="Bugis">Bugis</option>
                                                        <option value="City Hall">City Hall</option>
                                                        <option value="Raffles Place">Raffles Place</option>
                                                        <option value="Tanjong Pagar">Tanjong Pagar</option>
                                                        <option value="Outram Park">Outram Park</option>
                                                        <option value="Tiong Bahru">Tiong Bahru</option>
                                                        <option value="Redhill">Redhill</option>
                                                        <option value="Queenstown">Queenstown</option>
                                                        <option value="Commonwealth">Commonwealth</option>
                                                        <option value="Buona Vista">Buona Vista</option>
                                                        <option value="Dover">Dover</option>
                                                        <option value="Clementi">Clementi</option>
                                                        <option value="Jurong East">Jurong East</option>
                                                        <option value="Chinese Garden">Chinese Garden</option>
                                                        <option value="Lakeside">Lakeside</option>
                                                        <option value="Boon Lay">Boon Lay</option>
                                                        <option value="Pioneer">Pioneer</option>
                                                        <option value="Joo Koon">Joo Koon</option>
                                                        <option value="Gul Circle">Gul Circle</option>
                                                        <option value="Tuas Crescent">Tuas Crescent</option>
                                                        <option value="Tuas West Road">Tuas West Road</option>
                                                        <option value="Tuas Link">Tuas Link</option>
                                                    </optgroup>
                                                    <optgroup label="North South Line">
                                                        <option value="Jurong East">Jurong East</option>
                                                        <option value="Bukit Batok">Bukit Batok</option>
                                                        <option value="Bukit Gombak">Bukit Gombak</option>
                                                        <option value="Choa Chu Kang">Choa Chu Kang</option>
                                                        <option value="Yew Tee">Yew Tee</option>
                                                        <option value="Kranji">Kranji</option>
                                                        <option value="Marsiling">Marsiling</option>
                                                        <option value="Woodlands">Woodlands</option>
                                                        <option value="Admiralty">Admiralty</option>
                                                        <option value="Sembawang">Sembawang</option>
                                                        <option value="Canberra">Canberra</option>
                                                        <option value="Yishun">Yishun</option>
                                                        <option value="Khatib">Khatib</option>
                                                        <option value="Yio Chu Kang">Yio Chu Kang</option>
                                                        <option value="Ang Mo Kio">Ang Mo Kio</option>
                                                        <option value="Braddell">Braddell</option>
                                                        <option value="Toa Payoh">Toa Payoh</option>
                                                        <option value="Novena">Novena</option>
                                                        <option value="Newton">Newton</option>
                                                        <option value="Orchard">Orchard</option>
                                                        <option value="Somerset">Somerset</option>
                                                        <option value="Dhoby Ghaut">Dhoby Ghaut</option>
                                                        <option value="City Hall">City Hall</option>
                                                        <option value="Raffles Place">Raffles Place</option>
                                                        <option value="Marina Bay">Marina Bay</option>
                                                        <option value="Marina South Pier">Marina South Pier</option>
                                                    </optgroup>
                                                    <optgroup label="North East Line">
                                                        <option value="HarbourFront">HarbourFront</option>
                                                        <option value="Ourtram Park">Ourtram Park</option>
                                                        <option value="Chinatown">Chinatown</option>
                                                        <option value="Clarke Quay">Clarke Quay</option>
                                                        <option value="Dhoby Ghaut">Dhoby Ghaut</option>
                                                        <option value="Little India">Little India</option>
                                                        <option value="Farrer Park">Farrer Park</option>
                                                        <option value="Boon Keng">Boon Keng</option>
                                                        <option value="Potong Pasir">Potong Pasir</option>
                                                        <option value="Woodleigh">Woodleigh</option>
                                                        <option value="Serangoon">Serangoon</option>
                                                        <option value="Kovan">Kovan</option>
                                                        <option value="Hougang">Hougang</option>
                                                        <option value="Buangkok">Buangkok</option>
                                                        <option value="Sengkang">Sengkang</option>
                                                        <option value="Punggol">Punggol</option>
                                                    </optgroup>
                                                    <optgroup label="Circle Line">
                                                        <option value="Marina Bay">Marina Bay</option>
                                                        <option value="Bayfront">Bayfront</option>
                                                        <option value="Esplanade">Esplanade</option>
                                                        <option value="Bras Basah">Bras Basah</option>
                                                        <option value="Dhoby Ghaut">Dhoby Ghaut</option>
                                                        <option value="Promenade">Promenade</option>
                                                        <option value="Nicoll Highway">Nicoll Highway</option>
                                                        <option value="Stadium">Stadium</option>
                                                        <option value="Mountbatten">Mountbatten</option>
                                                        <option value="Dakota">Dakota</option>
                                                        <option value="Paya Lebar">Paya Lebar</option>
                                                        <option value="Macpherson">Macpherson</option>
                                                        <option value="Tai Seng">Tai Seng</option>
                                                        <option value="Bartley">Bartley</option>
                                                        <option value="Serangoon">Serangoon</option>
                                                        <option value="Lorong Chuan">Lorong Chuan</option>
                                                        <option value="Bishan">Bishan</option>
                                                        <option value="Marymount">Marymount</option>
                                                        <option value="Caldecott">Caldecott</option>
                                                        <option value="Botanic Gardens">Botanic Gardens</option>
                                                        <option value="Farrer Road">Farrer Road</option>
                                                        <option value="Holland Village">Holland Village</option>
                                                        <option value="Buona Vista">Buona Vista</option>
                                                        <option value="one-north">one-north</option>
                                                        <option value="Kent Ridge">Kent Ridge</option>
                                                        <option value="Haw Par Villa">Haw Par Villa</option>
                                                        <option value="Pasir Panjang">Pasir Panjang</option>
                                                        <option value="Labrador Park">Labrador Park</option>
                                                        <option value="Telok Blangah">Telok Blangah</option>
                                                        <option value="HarbourFront">HarbourFront</option>
                                                    </optgroup>
                                                    <optgroup label="Downtown Line">
                                                        <option value="Bukit Panjang">Bukit Panjang</option>
                                                        <option value="Cashew">Cashew</option>
                                                        <option value="Hillview">Hillview</option>
                                                        <option value="Beauty World">Beauty World</option>
                                                        <option value="King Albert Park">King Albert Park</option>
                                                        <option value="Sixth Avenue">Sixth Avenue</option>
                                                        <option value="Tan Kah Kee">Tan Kah Kee</option>
                                                        <option value="Botanic Gardens">Botanic Gardens</option>
                                                        <option value="Stevens">Stevens</option>
                                                        <option value="Newton">Newton</option>
                                                        <option value="Little India">Little India</option>
                                                        <option value="Rochor">Rochor</option>
                                                        <option value="Bugis">Bugis</option>
                                                        <option value="Promenade">Promenade</option>
                                                        <option value="Downtown">Downtown</option>
                                                        <option value="Telok Ayer">Telok Ayer</option>
                                                        <option value="Chinatown">Chinatown</option>
                                                        <option value="Fort Canning">Fort Canning</option>
                                                        <option value="Bencoolen">Bencoolen</option>
                                                        <option value="Jalan Besar">Jalan Besar</option>
                                                        <option value="Bendemeer">Bendemeer</option>
                                                        <option value="Geylang Bahru">Geylang Bahru</option>
                                                        <option value="Macpherson">Macpherson</option>
                                                        <option value="Ubi">Ubi</option>
                                                        <option value="Kaki Bukit">Kaki Bukit</option>
                                                        <option value="Bedok North">Bedok North</option>
                                                        <option value="Bedok Reservoir">Bedok Reservoir</option>
                                                        <option value="Tampines West">Tampines West</option>
                                                        <option value="Tampaines">Tampaines</option>
                                                        <option value="Upper Changi">Upper Changi</option>
                                                        <option value="Expo">Expo</option>
                                                        <option value="Xilin">Xilin</option>
                                                        <option value="Sungei Bedok">Sungei Bedok</option>
                                                    </optgroup>
                                                    <optgroup label="Bukit Panjang LRT">
                                                        <option value="Choa Chu Kang">Choa Chu Kang</option>
                                                        <option value="South View">South View</option>
                                                        <option value="Keat Hong">Keat Hong</option>
                                                        <option value="Teck Whye">Teck Whye</option>
                                                        <option value="Phoenix">Phoenix</option>
                                                        <option value="Ten Mile Junction">Ten Mile Junction</option>
                                                        <option value="Bukit Panjang">Bukit Panjang</option>
                                                        <option value="Senja">Senja</option>
                                                        <option value="Petir">Petir</option>
                                                        <option value="Pending">Pending</option>
                                                        <option value="Bangkit">Bangkit</option>
                                                        <option value="Fajar">Fajar</option>
                                                        <option value="Segar">Segar</option>
                                                        <option value="Jelapang">Jelapang</option>
                                                    </optgroup>
                                                    <optgroup label="Sengkang LRT">
                                                        <option value="Sengkang">Sengkang</option>
                                                        <option value="Compassvale">Compassvale</option>
                                                        <option value="Rumbia">Rumbia</option>
                                                        <option value="Bakau">Bakau</option>
                                                        <option value="Kangkar">kangkar</option>
                                                        <option value="Ranggung">Ranggung</option>
                                                        <option value="Renjong">Renjong</option>
                                                        <option value="Cheng Lim">Cheng Lim</option>
                                                        <option value="Farmway">Farmway</option>
                                                        <option value="Kupang">Kupang</option>
                                                        <option value="Thanggam">Thanggam</option>
                                                        <option value="Fernvale">Fernvale</option>
                                                        <option value="Layar">Layar</option>
                                                        <option value="Tongkang">Tongkang</option>
                                                    </optgroup>
                                                    <optgroup label="Punggol LRT">
                                                        <option value="Punggol">Punggol</option>
                                                        <option value="Cove">Cove</option>
                                                        <option value="Meridian">Meridian</option>
                                                        <option value="Coral Edge">Coral Edge</option>
                                                        <option value="Riviera">Riviera</option>
                                                        <option value="Kadaloor">Kadaloor</option>
                                                        <option value="Oasis">Oasis</option>
                                                        <option value="Damai">Damai</option>
                                                        <option value="Soo Teck">Soo Teck</option>
                                                        <option value="Sumang">Sumang</option>
                                                        <option value="Nibong">Nibong</option>
                                                        <option value="Samudera">Samudera</option>
                                                        <option value="Punggol Point">Punggol Point</option>
                                                        <option value="Tech Lee">Tech Lee</option>
                                                        <option value="Sam Kee">Sam Kee</option>
                                                    </optgroup>undefined</select>
                                            </div>
                                        </div>
                                    </div>

                                    <div className="row">
                                        <div className="col-md-12">
                                            <div className="form-group">
                                                <label htmlFor="address">Address</label>
                                                <input className="form-control" name="address" type="text" id="address" />
                                            </div>
                                        </div>
                                    </div>


                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        );
    }
}
