import {$authHost, $host} from "./index";

export const createKind = async (kinds) => {
    const {data} = await $authHost.post('http://localhost:8082/itactive/api/v1/kinds', kinds)
    return data
}

export const fetchKind = async () => {
    const {data} = await $host.get('http://localhost:8082/itactive/api/v1/kinds')
    return data
}

export const createProducers = async (producers) => {
    const {data} = await $authHost.post('http://localhost:8082/itactive/api/v1/producers', producers)
    return data
}

export const fetchProducers = async () => {
    const {data} = await $host.get('http://localhost:8082/itactive/api/v1/producers')
    return data
}

export const createActives = async (actives) => {
    const {data} = await $authHost.post('http://localhost:8082/itactive/api/v1/actives', actives)
    return data
}

export const fetchActives = async (owner_Id, kind_id, producer_id, model, serial_number, condition_id, page, limit = 3) => {
    const {data} = await $host.get('http://localhost:8082/itactive/api/v1/actives', {
        params: {
            (owner_Id, kind_id, producer_id, model, serial_number, condition_id, page, limit
        }
    })
    return data
}
export const fetchOneDevices = async (id) => {
    const {data} = await $host.get('http://localhost:8082/itactive/api/v1/actives/' + id)
    return data
}

export const createCondition = async (condition) => {
    const {data} = await $authHost.post('http://localhost:8082/itactive/api/v1/condition', condition)
    return data
}

export const fetchConditions = async () => {
    const {data} = await $host.get('http://localhost:8082/itactive/api/v1/condition')
    return data
}

export const addOrder = async (orderId) => {
    const {response} = await $authHost.post('http://localhost:8082/itactive/api/v1/order', orderId)
    return response
}

export const getOrder = async () => {
    const {data} = await $authHost.get('http://localhost:8082/itactive/api/v1/order')
    return data
}