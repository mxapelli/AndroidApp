package edu.upc.androidapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class UserList {

    List<Usuario> usuarios = new List<Usuario>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(@Nullable Object o) {
            return false;
        }

        @NonNull
        @Override
        public Iterator<Usuario> iterator() {
            return null;
        }

        @NonNull
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @NonNull
        @Override
        public <T> T[] toArray(@NonNull T[] a) {
            return null;
        }

        @Override
        public boolean add(Usuario usuario) {
            return false;
        }

        @Override
        public boolean remove(@Nullable Object o) {
            return false;
        }

        @Override
        public boolean containsAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(@NonNull Collection<? extends Usuario> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, @NonNull Collection<? extends Usuario> c) {
            return false;
        }

        @Override
        public boolean removeAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Usuario get(int index) {
            return null;
        }

        @Override
        public Usuario set(int index, Usuario element) {
            return null;
        }

        @Override
        public void add(int index, Usuario element) {

        }

        @Override
        public Usuario remove(int index) {
            return null;
        }

        @Override
        public int indexOf(@Nullable Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(@Nullable Object o) {
            return 0;
        }

        @NonNull
        @Override
        public ListIterator<Usuario> listIterator() {
            return null;
        }

        @NonNull
        @Override
        public ListIterator<Usuario> listIterator(int index) {
            return null;
        }

        @NonNull
        @Override
        public List<Usuario> subList(int fromIndex, int toIndex) {
            return null;
        }
    };
}
