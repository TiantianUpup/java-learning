package com.h2t.study.builder;

/**
 * TODO Description
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/27 16:57
 */
public class FileSetPO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 文件集合大小
     */
    private double size;

    /**
     * 文件集合状态
     */
    private int status;

    public FileSetPO() {

    }

    public FileSetPO(Builder builder) {
        this.id = builder.id;
        this.size = builder.size;
        this.status = builder.status;
    }

    @Override
    public String toString() {
        return "FileSetPO{" +
                "id=" + id +
                ", size=" + size +
                ", status=" + status +
                '}';
    }

    public static class Builder {
        /**
         * 主键
         */
        private Long id;

        /**
         * 文件集合大小
         */
        private double size;

        /**
         * 文件集合状态
         */
        private int status;

        public Builder() {
        }

        public Builder(Long id, double size, int status) {
            this.id = id;
            this.size = size;
            this.status = status;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder size(int size) {
            this.size = size;
            return this;
        }

        public FileSetPO build() {
            return new FileSetPO(this);
        }

    }
}
