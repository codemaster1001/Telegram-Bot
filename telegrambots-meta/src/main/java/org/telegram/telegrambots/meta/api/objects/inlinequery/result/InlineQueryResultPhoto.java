package org.telegram.telegrambots.meta.api.objects.inlinequery.result;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.inlinequery.inputmessagecontent.InputMessageContent;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiValidationException;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * Represents a link to a photo. By default, this photo will be sent by the user with
 * optional caption. Alternatively, you can use input_message_content to send a message with the
 * specified content instead of the photo.
 */
@JsonDeserialize
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InlineQueryResultPhoto implements InlineQueryResult {
    private static final String TYPE_FIELD = "type";
    private static final String ID_FIELD = "id";
    private static final String PHOTOURL_FIELD = "photo_url";
    private static final String MIMETYPE_FIELD = "mime_type";
    private static final String PHOTOWIDTH_FIELD = "photo_width";
    private static final String PHOTOHEIGHT_FIELD = "photo_height";
    private static final String THUMBURL_FIELD = "thumb_url";
    private static final String TITLE_FIELD = "title";
    private static final String DESCRIPTION_FIELD = "description";
    private static final String CAPTION_FIELD = "caption";
    private static final String INPUTMESSAGECONTENT_FIELD = "input_message_content";
    private static final String REPLY_MARKUP_FIELD = "reply_markup";
    private static final String PARSEMODE_FIELD = "parse_mode";

    @JsonProperty(TYPE_FIELD)
    private final String type = "photo"; ///< Type of the result, must be “photo”
    @JsonProperty(ID_FIELD)
    @NonNull
    private String id; ///< Unique identifier of this result, 1-64 bytes
    @JsonProperty(PHOTOURL_FIELD)
    @NonNull
    private String photoUrl; ///< A valid URL of the photo. Photo size must not exceed 5MB
    @JsonProperty(MIMETYPE_FIELD)
    private String mimeType; ///< Optional. MIME type of the photo, defaults to image/jpeg
    @JsonProperty(PHOTOWIDTH_FIELD)
    private Integer photoWidth; ///< Optional. Width of the photo
    @JsonProperty(PHOTOHEIGHT_FIELD)
    private Integer photoHeight; ///< Optional. Height of the photo
    @JsonProperty(THUMBURL_FIELD)
    private String thumbUrl; ///< Optional. URL of the thumbnail for the photo
    @JsonProperty(TITLE_FIELD)
    private String title; ///< Optional. Title for the result
    @JsonProperty(DESCRIPTION_FIELD)
    private String description; ///< Optional. Short description of the result
    @JsonProperty(CAPTION_FIELD)
    private String caption; ///< Optional. Caption of the photo to be sent
    @JsonProperty(INPUTMESSAGECONTENT_FIELD)
    private InputMessageContent inputMessageContent; ///< Optional. Content of the message to be sent instead of the photo
    @JsonProperty(REPLY_MARKUP_FIELD)
    private InlineKeyboardMarkup replyMarkup; ///< Optional. Inline keyboard attached to the message
    @JsonProperty(PARSEMODE_FIELD)
    private String parseMode; ///< Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.

    @Override
    public void validate() throws TelegramApiValidationException {
        if (id == null || id.isEmpty()) {
            throw new TelegramApiValidationException("ID parameter can't be empty", this);
        }
        if (photoUrl == null || photoUrl.isEmpty()) {
            throw new TelegramApiValidationException("PhotoUrl parameter can't be empty", this);
        }
        if (inputMessageContent != null) {
            inputMessageContent.validate();
        }
        if (replyMarkup != null) {
            replyMarkup.validate();
        }
    }
}
