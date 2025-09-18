package org.korea_app_backend.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
@Service
public class QRCodeService {
    public static byte[] generateQRCode(String text, int width, int height)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        // Cấu hình: bỏ margin và dùng mức Error Correction M
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.MARGIN, 0);
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);

        // Lấy vùng QR thật sự (không viền thừa)
        int[] rect = bitMatrix.getEnclosingRectangle();
        int rectX = rect[0];
        int rectY = rect[1];
        int rectWidth = rect[2];
        int rectHeight = rect[3];

        // Tạo ảnh nền trắng
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);

        graphics.setColor(Color.BLACK);

        // Tính scale chuẩn để mỗi module QR là hình vuông
        int scaleX = width / rectWidth;
        int scaleY = height / rectHeight;
        int scale = Math.min(scaleX, scaleY);

        // Vẽ QR code
        for (int x = 0; x < rectWidth; x++) {
            for (int y = 0; y < rectHeight; y++) {
                if (bitMatrix.get(x + rectX, y + rectY)) {
                    graphics.fillRect(x * scale, y * scale, scale, scale);
                }
            }
        }
        graphics.dispose();

        // Xuất ra mảng byte PNG
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        return baos.toByteArray();
    }
}
