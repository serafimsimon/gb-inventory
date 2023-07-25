import {makeAutoObservable} from "mobx";

export default class UserStore {
    constructor() {
        this._users = []
        this._jobs = []
        this._departments = []
        this._isAuth = true
        this._isAdmin = true
        this._isStorage = true
        this._selectedDepartment = {}
        this._selectedJob = {}
        makeAutoObservable(this)
    }

    setIsAuth(bool) {
        this._isAuth = bool
    }

    setUsers(users) {
        this._users = users
    }

    setIsAdmin(admin) {
        this._isAdmin = admin
    }

    setIsStorage(storage) {
        this._isStorage = storage
    }

    setDepartments(departments) {
        this._departments = departments
    }

    setJobs(jobs) {
        this._jobs = jobs
    }

    setSelectedDepartment(department) {
        this._selectedDepartment = department
    }

    setSelectedJob(job) {
        this._selectedJob = job
    }


    get isAuth() {
        return this._isAuth
    }

    get users() {
        return this._users
    }

    get isAdmin() {
        return this._isAdmin
    }

    get isStorage() {
        return this._isStorage
    }

    get departments() {
        return this._departments
    }

    get jobs() {
        return this._jobs
    }

    get selectedDepartment() {
        return this._selectedDepartment
    }

    get selectedJob() {
        return this._selectedJob
    }

}