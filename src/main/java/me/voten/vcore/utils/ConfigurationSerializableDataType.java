package me.voten.vcore.utils;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ConfigurationSerializableDataType <T extends ConfigurationSerializable> implements PersistentDataType<byte[], T> {
    private final Class<T> type;

    public ConfigurationSerializableDataType(Class<T> type) {
        this.type = type;
    }

    @NotNull
    @Override
    public Class<byte[]> getPrimitiveType() {
        return byte[].class;
    }

    @NotNull
    @Override
    public Class<T> getComplexType() {
        return type;
    }

    @Override
    public byte @NotNull [] toPrimitive(@NotNull T serializable, @NotNull PersistentDataAdapterContext persistentDataAdapterContext) {
        try (
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                BukkitObjectOutputStream bukkitObjectOutputStream = new BukkitObjectOutputStream(outputStream)
        ) {
            bukkitObjectOutputStream.writeObject(serializable);
            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @NotNull
    @Override
    @SuppressWarnings("unchecked")
    public T fromPrimitive(byte @NotNull [] bytes, @NotNull PersistentDataAdapterContext persistentDataAdapterContext) {
        try (
                ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
                BukkitObjectInputStream bukkitObjectInputStream = new BukkitObjectInputStream(inputStream)
        ) {
            return (T) bukkitObjectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}