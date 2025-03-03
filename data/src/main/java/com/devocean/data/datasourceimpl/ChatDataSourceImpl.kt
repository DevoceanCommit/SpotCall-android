package com.devocean.data.datasourceimpl

import com.devocean.data.datasource.ChatDataSource
import com.devocean.data.dto.response.ChatResponseDto
import com.devocean.data.dto.response.SelectedChatResponseDto
import com.devocean.data.dto.response.SummaryReportResponseDto
import com.devocean.data.service.ChatService
import javax.inject.Inject

class ChatDataSourceImpl @Inject constructor(
    private val service: ChatService
) : ChatDataSource {
    override suspend fun getChatList(): List<ChatResponseDto> = service.getChatList()

    override suspend fun getSelectedChat(sessionId: Int): SelectedChatResponseDto =
        service.getSelectedChat(sessionId)

    override suspend fun getSummaryReport(sessionId: Int): SummaryReportResponseDto =
        service.getSummaryReport(sessionId)
}