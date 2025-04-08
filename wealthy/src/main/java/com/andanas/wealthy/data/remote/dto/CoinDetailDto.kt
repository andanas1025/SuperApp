package com.andanas.wealthy.data.remote.dto

import com.andanas.wealthy.domain.model.CoinDetail

data class CoinDetailDto(
    val contract: String,
    val contracts: List<Contract>,
    val description: String,
    val development_status: String,
    val first_data_at: String,
    val hardware_wallet: Boolean,
    val hash_algorithm: String,
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val last_data_at: String,
    val links: Links,
    val links_extended: List<LinksExtended>,
    val logo: String,
    val message: String,
    val name: String,
    val open_source: Boolean,
    val org_structure: String,
    val parent: Parent,
    val platform: String,
    val proof_type: String,
    val rank: Int,
    val started_at: String,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<Team>,
    val type: String,
    val whitepaper: Whitepaper
)

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        id = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        is_active = is_active,
        is_new = is_new,
        type = type,
        contract = TODO(),
        contracts = TODO(),
        development_status = TODO(),
        first_data_at = TODO(),
        hardware_wallet = TODO(),
        hash_algorithm = TODO(),
        last_data_at = TODO(),
        links = TODO(),
        links_extended = TODO(),
        logo = TODO(),
        message = TODO(),
        open_source = TODO(),
        org_structure = TODO(),
        parent = TODO(),
        platform = TODO(),
        proof_type = TODO(),
        started_at = TODO(),
        tags = TODO(),
        team = TODO(),
        whitepaper = TODO()
    )
}