import { Candidate } from "./Candidate";
import { StateJobInterview } from "./StateJobInterview";

export class JobInterview{
    
    public idJobInterview!:number;

	public date!:Date;

	public notes!:string;

	public outcome!:number;

	public candidate!:Candidate;

	public stateJobInterview!:StateJobInterview;

}